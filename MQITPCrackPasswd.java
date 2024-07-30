import com.ibm.mq.ipt.crypto.CryptoUtil;
import com.ibm.mq.ipt.trace.TraceWrapper;
import com.ibm.mq.ipt.crypto.EncodedPassword;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class MQITPCrackPasswd {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -cp .:libs/com.ibm.mq.ipt.jar MQITPCrackPasswd <protection mode> <encodedPasswordFilePath>");
            return;
        }

        int version = Integer.parseInt(args[0]);
        String filePath = args[1];

        try {
            // Initialiser le TraceWrapper
            TraceWrapper.processInit();

            // Lire le contenu du fichier en tant que tableau de bytes
            byte[] encodedPasswordBytes = Files.readAllBytes(Paths.get(filePath));

            CryptoUtil util = new CryptoUtil();
            TraceWrapper traceWrapper = new TraceWrapper(); // Initialisé après le processInit()
            EncodedPassword encodedPassword = new EncodedPassword(encodedPasswordBytes);

            // Utilise la méthode decryptPasswordAsString avec les bons paramètres
            String decodedPassword = util.decryptPasswordAsString(traceWrapper, filePath, encodedPassword);
            System.out.println("Decoded password: " + decodedPassword);
        } catch (IOException e) {
            System.err.println("Error reading the encoded password file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

