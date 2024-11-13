package model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Base64;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class Qr {

	public String generateCodeQr() {
		String data = "Robinson Gutierrez";
		String filePath = "QRCode.png";
		String fileType = "png";
		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 300, 300);
			Path path = FileSystems.getDefault().getPath(filePath);
			MatrixToImageWriter.writeToPath(bitMatrix, fileType, path);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, fileType, baos);
			byte[] qrCodeBytes = baos.toByteArray();
			String qrCodeString = Base64.getEncoder().encodeToString(qrCodeBytes);
			return qrCodeString;
		} catch (WriterException | IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
