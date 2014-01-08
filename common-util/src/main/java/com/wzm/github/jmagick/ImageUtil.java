package com.wzm.github.jmagick;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.MemoryCacheImageInputStream;

import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import com.wzm.github.log.MLWLogger;
import com.wzm.github.log.MLWLoggerFactory;

/**
 * 
 * @author lsf
 * 
 */
public class ImageUtil {

	private final static MLWLogger LOG = MLWLoggerFactory.getLogger(ImageUtil.class);

	public static final String W_H_SPLITER = "x";
	public static final String COMPRESSION_IDENTITY = "comp";

	public static final String TMP_SUFFIX = ".tmp.jpg";

	/**
	 * 
	 * @param fromImg 原图路径
	 * @param toImg 被缩放后的图片路径
	 * @param widthPx 被缩放的宽度
	 * @param heightPx 被缩放的高度
	 * @throws MagickException 压缩不成功，可能会跑出该异常
	 */
	public static void scaleImg(String fromImg, String toImg, int widthPx,
			int heightPx) throws MagickException {
		MagickImage magickImg = null;
		try {
			ImageInfo fromImgInfo = new ImageInfo(fromImg);

			MagickImage mgkImage = new MagickImage(fromImgInfo);

			magickImg = mgkImage.scaleImage(widthPx, heightPx);
			magickImg.setFileName(toImg);

			LOG.debug("begin to scaled image '" + fromImg + "' to image '"
					+ toImg + "' with width " + widthPx + "px and height "
					+ heightPx + "px.");

			magickImg.writeImage(fromImgInfo);

			LOG.debug("scaled image '" + fromImg + "' success!");
		} finally {
			if (magickImg != null) {
				magickImg.destroyImages();
			}
		}
	}

	/**
	 * 
	 * @param fromImg 原图路径
	 * @param width 被缩放的宽度
	 * @param height 被缩放的高度
	 * @return 按指定的宽度或高度，计算出压缩比后进行压缩。如果压缩成功，则返回压缩后的图片名称；如果压缩失败，则返回原图的文件名
	 */
	public static String ratioScaleImg(String fromImg, int width, int height) {
		MagickImage magickImg = null;
		String filename = FilenameUtils.getName(fromImg);
		try {
			ImageInfo fromImgInfo = new ImageInfo(fromImg);
			magickImg = new MagickImage(fromImgInfo);

			Dimension dim = magickImg.getDimension();
			int accessSize = width;
			double widthPx = dim.getWidth();
			double heightPx = dim.getHeight();
			if (width > 0) {
				height = (int) (heightPx * (width / widthPx));
			} else if (height > 0) {
				accessSize = height;
				width = (int) (widthPx * (height / heightPx));
			} else {
				LOG.warn("one of width or height should be over zero.", "fromImg:" + fromImg + ",width:" + width + ",height:" + height, null);
				return filename;
			}

			String ext = FilenameUtils.getExtension(filename);
			filename = filename + accessSize + "." + ext;

			String baseDir = FilenameUtils.getFullPath(fromImg);

			scaleImg(fromImg, baseDir + filename, width, height);

		} catch (Exception e) {
			LOG.error(e, "fromImg:" + fromImg + ",width:" + width + ",height:" + height, null);

			return FilenameUtils.getName(fromImg);
		}

		return filename;
	}

	/**
	 * 
	 * @param fromImg 原图路径
	 * @param widthPx 被缩放的宽度
	 * @param heightPx 被缩放的高度
	 * @return 如果压缩成功，则返回压缩后的图片名称；如果压缩失败，则返回原图的文件名
	 */
	public static String scaleImg(String fromImg, int widthPx, int heightPx) {
		final String size = widthPx + W_H_SPLITER + heightPx;
		String filename = FilenameUtils.getName(fromImg);
		try {
			String baseDir = FilenameUtils.getFullPath(fromImg);

			String ext = FilenameUtils.getExtension(filename);
			filename = filename + size + "." + ext;

			String filePath = baseDir + filename;

			scaleImg(fromImg, filePath, widthPx, heightPx);

		} catch (MagickException e) {
			LOG.error(e, "fromImg:" + fromImg + ",widthPx:" + widthPx + ",heightPx:" + heightPx, null);

			return FilenameUtils.getName(fromImg);
		}

		return filename; // 压缩成功，则将resultDir+"/"+文件名返回
	}

	/**
	 * 
	 * @param fromImg 原图路径
	 * @param toImg 被压缩后的图片路径
	 * @param quality 压缩质量，从0到100之间的数字
	 * @throws MagickException 压缩不成功，可能会跑出该异常
	 */
	public static void compressionImg(String fromImg, String toImg, int quality)
			throws MagickException {
		MagickImage magickImg = null;
		try {
			ImageInfo fromImgInfo = new ImageInfo(fromImg);
			fromImgInfo.setQuality(quality);

			magickImg = new MagickImage(fromImgInfo);
			magickImg.setFileName(toImg);

			LOG.debug("begin to compress image '" + fromImg
					+ "' to compressed image '" + toImg + "'");

			magickImg.writeImage(fromImgInfo);

			LOG.debug("compress image '" + fromImg + "' success");
		} finally {
			if (magickImg != null) {
				magickImg.destroyImages();
			}
		}
	}

	/**
	 * 
	 * @param fromImg 原图路径
	 * @param quality 压缩质量，从0到100之间的数字
	 * @return 如果压缩成功，则返回压缩后的图片名称；如果压缩失败，则返回原图的文件名
	 */
	public static String compressionImg(String fromImg, int quality) {
		String filename = FilenameUtils.getName(fromImg);
		try {
			String baseDir = FilenameUtils.getFullPath(fromImg);

			String ext = FilenameUtils.getExtension(filename);
			filename = filename + COMPRESSION_IDENTITY + "." + ext;

			String filePath = baseDir + filename;

			compressionImg(fromImg, filePath, quality);

		} catch (MagickException e) {
			LOG.error(e, "fromImg:" + fromImg + ",quality:" + quality, null);

			return FilenameUtils.getName(fromImg);
		}

		return filename; // 压缩成功，则将resultDir+"/"+文件名返回
	}

	/**
	 * 对图片进行裁切
	 * 
	 * @param fromImg 原图路径
	 * @param toImg 被裁切后的图片路径
	 * @param x 相对图片左上角的x坐标
	 * @param y 相对图片左上角的y坐标
	 * @param w 裁切宽度
	 * @param h 裁切高度
	 * @throws MagickException 压缩不成功，可能会跑出该异常
	 */
	public static void cutImg(String fromImg, String toImg, int x, int y,
			int w, int h) throws MagickException {
		MagickImage magickImg = null;
		Rectangle rect = null;
		try {
			ImageInfo fromImgInfo = new ImageInfo(fromImg);
			magickImg = new MagickImage(fromImgInfo);
			rect = new Rectangle(x, y, w, h);
			magickImg = magickImg.cropImage(rect);
			magickImg.setFileName(toImg);

			LOG.debug("begin to cut image '" + fromImg + "' to image '" + toImg
					+ "' with rect[" + x + "," + y + "," + w + "," + h + "]");

			magickImg.writeImage(fromImgInfo);

			LOG.debug("cut image '" + fromImg + "' success");
		} finally {
			if (magickImg != null) {
				magickImg.destroyImages();
			}
		}
	}

	/**
	 * 
	 * @param fromImg 原图路径
	 * @param x 相对图片左上角的x坐标
	 * @param y 相对图片左上角的y坐标
	 * @param w 裁切宽度
	 * @param h 裁切高度
	 * @return 如果压缩成功，则返回压缩后的图片名称；如果压缩失败，则返回原图的文件名
	 */
	public static String cutImg(String fromImg, int x, int y, int w, int h) {
		final String size = w + W_H_SPLITER + h;
		String filename = FilenameUtils.getName(fromImg);
		try {
			String baseDir = FilenameUtils.getFullPath(fromImg);

			String ext = FilenameUtils.getExtension(filename);
			filename = filename + size + "." + ext;

			String filePath = baseDir + filename;

			cutImg(fromImg, filePath, x, y, w, h);

		} catch (MagickException e) {
			LOG.error(e, "fromImg:" + fromImg + ",x:" + x + ",y:" + y + ",w:" + w + ",h:" + h, null);

			return FilenameUtils.getName(fromImg);
		}

		return filename; // 压缩成功，则将resultDir+"/"+文件名返回
	}

	/**
	 * 
	 * @param fromImg 原图路径
	 * @param x 相对图片左上角的x坐标
	 * @param y 相对图片左上角的y坐标
	 * @param leftx 相对图片左上角的另外一个x坐标
	 * @param topy  相对图片左上角的另外一个y坐标
	 * @return 如果压缩成功，则返回压缩后的图片名称；如果压缩失败，则返回原图的文件名
	 */
	public static String cutImgByPx(String fromImg, double x, double y,
			double leftx, double topy) {
		int width = (int) Math.abs(leftx - x);
		int height = (int) Math.abs(topy - y);

		return cutImg(fromImg, (int) x, (int) y, width, height);
	}

	/**
	 * 
	 * @param fromImg 原图路径
	 * @param toImg 被裁切后的图片路径
	 * @param x 相对图片左上角的x坐标
	 * @param y 相对图片左上角的y坐标
	 * @param leftx 相对图片左上角的另外一个x坐标
	 * @param topy  相对图片左上角的另外一个y坐标
	 * @return 如果压缩成功，则返回压缩后的图片名称；如果压缩失败，则返回原图的文件名
	 */
	public static boolean cutImgByPx(String fromImg, String toImg, double x,
			double y, double leftx, double topy) {
		int width = (int) Math.abs(leftx - x);
		int height = (int) Math.abs(topy - y);

		try {
			cutImg(fromImg, toImg, (int) x, (int) y, width, height);
		} catch (MagickException e) {
			LOG.error(e, "fromImg:" + fromImg + ",toImg:" + toImg, null);
		}

		return new File(toImg).exists();
	}

	/**
	 * 
	 * @param fromImg 原图路径
	 * @param width 压缩后的宽度
	 * @param height 压缩后的高度 
	 * @param quality 压缩质量，从0到100之间的数字
	 * @return 如果压缩成功，则返回压缩后的图片名称；如果压缩失败，则返回原图的文件名
	 */
	public static String convertUploadImg(String fromImg, int width,
			int height, int quality) {
		MagickImage magickImg = null;
		final String size = width + W_H_SPLITER + height;
		String filename = FilenameUtils.getName(fromImg);
		try {
			ImageInfo fromImgInfo = new ImageInfo(fromImg);
			fromImgInfo.setQuality(quality);
			magickImg = new MagickImage(fromImgInfo);

			// Dimension dim = magickImg.getDimension();
			// int sideLength = (int) dim.getWidth(); // 计算正方形边长
			// if (sideLength > dim.getHeight()) {
			// sideLength = (int) dim.getHeight();
			// }

			// rect = new Rectangle(0, 0, sideLength, sideLength);
			// magickImg = magickImg.cropImage(rect);

			// if (width > sideLength) {
			// width = sideLength;
			// }
			// if (height > sideLength) {
			// height = sideLength;
			// }
			magickImg = magickImg.scaleImage(width, height);

			String baseDir = FilenameUtils.getFullPath(fromImg);

			checkDirs(baseDir);

			String ext = FilenameUtils.getExtension(filename);
			filename = filename + size + "." + ext;

			String filePath = baseDir + filename;

			magickImg.setFileName(filePath);

			LOG.debug("convert image '" + fromImg + "' to image '" + filePath
					+ "' with quality(" + quality + "),width(" + width
					+ "),height(" + height + ")");

			magickImg.writeImage(fromImgInfo);

			LOG.debug("convert image '" + fromImg + "' success");
		} catch (MagickException e) {
			LOG.error(e, "fromImg:" + fromImg + ",width:" + width + ",height:" + height + ",quality:" + quality, null);

			return FilenameUtils.getName(fromImg);
		} finally {
			if (magickImg != null) {
				magickImg.destroyImages();
			}
		}

		return filename;
	}

	/**
	 * 
	 * @param dir 被检测的目录路径
	 * 如果目录dir存在，则直接返回；如果不存在，则创建该路径
	 */
	private static void checkDirs(String dir) {
		File file = new File(dir);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	/**
	 * 
	 * <Description>获取图片的尺寸信息</Description>
	 * 
	 * @param fromImg 图片路径
	 * @return 获取包含该图片宽高的Dimension对象
	 * @throws MagickException 获取尺寸对象失败，有可能会抛出该异常
	 */
	public static Dimension getDimension(String fromImg) throws MagickException {
		ImageInfo fromImgInfo = new ImageInfo(fromImg);

		return new MagickImage(fromImgInfo).getDimension();
	}

	/**
	 * 
	 * @param mapObj 图片的字节码数组
	 * @return 如果该字节码数组确实为图片格式，则返回true；否则返回false
	 */
	public static boolean isImageType(byte[] mapObj) {
		boolean ret = false;
		ByteArrayInputStream bais = null;
		MemoryCacheImageInputStream mcis = null;
		try {
			bais = new ByteArrayInputStream(mapObj);
			mcis = new MemoryCacheImageInputStream(bais);
			Iterator<ImageReader> itr = ImageIO.getImageReaders(mcis);

			while (itr.hasNext()) {
				ImageReader reader = (ImageReader) itr.next();

				String imageName = reader.getClass().getSimpleName();

				if (imageName != null
						&& ("GIFImageReader".equals(imageName)
								|| "JPEGImageReader".equals(imageName)
								|| "PNGImageReader".equals(imageName) || "BMPImageReader"
									.equals(imageName))) {
					ret = true;
				}
			}
		} finally {
			// 关闭流
			if (mcis != null) {
				try {
					mcis.close();
				} catch (IOException e) {
					LOG.error(e, null, null);
				}
			}

			if (bais != null) {
				try {
					bais.close();
				} catch (IOException e) {
					LOG.error(e, null, null);
				}
			}
		}

		return ret;
	}

	/**
	 * 
	 * @param file 文件路径
	 * @return 如果该文件确实为图片格式，则返回true；否则返回false
	 * @throws IOException 
	 */
	public static boolean isImageType(String fileName) {
		return isImageType(new File(fileName));
	}

	/**
	 * 
	 * @param file 文件对象
	 * @return 如果该文件确实为图片格式，则返回true；否则返回false
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static boolean isImageType(File file)  {
		try {
			return isImageType(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			LOG.error(e, file == null ? null : file.getAbsolutePath(), null);
		}
		
		return false;
	}

	/**
	 * 
	 * @param input 文件流
	 * @return 如果该文件流确实为图片格式，则返回true；否则返回false
	 * @throws IOException
	 */
	public static boolean isImageType(InputStream input)  {
		try {
			return isImageType(IOUtils.toByteArray(input));
		} catch (IOException e) {
			LOG.error(e, null, null);
		}
		
		return false;
	}

}
