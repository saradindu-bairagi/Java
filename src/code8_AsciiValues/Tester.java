package code8_AsciiValues;

class ForTryout3 {
    public static void main(String[] args) {
        String inStr = "Java8";
        int strLen = inStr.length();  // calculate length of inStr , strLen=5
        for (int index = 0; index < strLen; index++) {
            //String method charAt() - used to extract each character from inStr
            //String index starts from 0
            char character = inStr.charAt(index);
            // Type cast(Implicit type cast) the character value to get the ascii value
            int asciiValue = character;
            System.out.println(character + " - " + asciiValue);
        }
    }
}