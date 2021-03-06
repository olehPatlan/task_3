public class Encoder {
    public static String encode(String message) {
        if (message == null || message.isEmpty()) {
            return message;
        }
        if (message.length() > 100) {
            throw new IllegalArgumentException();
        }

        byte[] lineBytes = message.getBytes();
        StringBuilder result = new StringBuilder();
        char prevChar = '-';
        for (byte mByte : lineBytes) {
            // 8 - amount of symbols in binary string ASCII 2^7 codes
            String binaryString = numberToBinaryString(mByte,8);
            for (int i = 0; i < binaryString.length(); i++) {
                char curChar = binaryString.charAt(i);
                if (curChar == prevChar) {
                    result.append("0");
                } else {
                    result.append(" ");
                    if (curChar == '0') {
                        result.append("00 0");
                    } else {
                        result.append("0 0");
                    }
                }
                prevChar = curChar;
            }
        }
        return result.toString().trim();
    }

    private static String numberToBinaryString(int input,int length) {
        StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(input));
        if (binaryString.length() < length) {
            StringBuilder newBinaryString = new StringBuilder();
            for (int i = 0; i < length - binaryString.length(); i++) {
                newBinaryString.append("0");
            }
            return newBinaryString.append(binaryString).toString();
        }
        return binaryString.toString();
    }
}