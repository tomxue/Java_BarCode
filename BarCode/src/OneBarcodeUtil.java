import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import org.jbarcode.JBarcode;
import org.jbarcode.encode.EAN13Encoder;
import org.jbarcode.encode.EAN8Encoder;
import org.jbarcode.paint.EAN13TextPainter;
import org.jbarcode.paint.EAN8TextPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;

public class OneBarcodeUtil {

	public static void main(String[] paramArrayOfString) {
		try {
			JBarcode localJBarcode = new JBarcode(EAN13Encoder.getInstance(),
					WidthCodedPainter.getInstance(),
					EAN13TextPainter.getInstance());
			String str = "312645612345";
			BufferedImage localBufferedImage = localJBarcode.createBarcode(str);

			saveToJPEG(localBufferedImage, "EAN13.jpg");
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}

	static void saveToJPEG(BufferedImage paramBufferedImage, String paramString) {
		saveToFile(paramBufferedImage, paramString, "jpeg");
	}

	static void saveToFile(BufferedImage paramBufferedImage,
			String paramString1, String paramString2) {
		try {
			FileOutputStream localFileOutputStream = new FileOutputStream(
					"C:\\Users\\xuejd1\\Desktop/" + paramString1);
			ImageUtil.encodeAndWrite(paramBufferedImage, paramString2,
					localFileOutputStream, 96, 96);
			localFileOutputStream.close();
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}
}