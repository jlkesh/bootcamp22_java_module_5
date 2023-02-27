package org.example.base64;

import java.util.Base64;

public class Base64Example {
    public static void main(String[] args) {
        // simpleBase64Example();
        // mimeBase64Example();
        /*Base64.Encoder urlEncoder = Base64.getUrlEncoder();
        Base64.Decoder urlDecoder = Base64.getUrlDecoder();
        String encodeToString = urlEncoder.encodeToString("\"a?".getBytes());
        System.out.println("encodeToString = " + encodeToString);
        String encodeToString2 =Base64.getEncoder().encodeToString("\"a?".getBytes());
        System.out.println("encodeToString2 = " + encodeToString2);*/

    }

    private static void mimeBase64Example() {
        Base64.Encoder mimeEncoder = Base64.getMimeEncoder();
        Base64.Decoder mimeDecoder = Base64.getMimeDecoder();
        String encodeToString = mimeEncoder.encodeToString("""
                package org.example.base64;
                                
                import java.util.Base64;
                                
                public class Base64Example {
                    public static void main(String[] args) {
                        // simpleBase64Example();
                        Base64.Encoder mimeEncoder = Base64.getMimeEncoder();
                        Base64.Decoder mimeDecoder = Base64.getMimeDecoder();
                        mimeEncoder.encodeToString("")
                                
                    }
                                
                    private static void simpleBase64Example() {
                        Base64.Encoder encoder = Base64.getEncoder();
                        Base64.Decoder decoder = Base64.getDecoder();
                        String encodedSTR = encoder.encodeToString("Hello PDP ".getBytes());
                        System.out.println("encodedSTR = " + encodedSTR);
                        byte[] decodedByteArray = decoder.decode(encodedSTR);
                        String decodedSTR = new String(decodedByteArray);
                        System.out.println("decodedSTR = " + decodedSTR);
                    }
                }
                              
                """.getBytes());
        System.out.println(encodeToString);
        System.out.println(new String(mimeDecoder.decode(encodeToString)));
    }

    private static void simpleBase64Example() {
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();
        String encodedSTR = encoder.encodeToString("Hello PDP ".getBytes());
        System.out.println("encodedSTR = " + encodedSTR);
        byte[] decodedByteArray = decoder.decode(encodedSTR);
        String decodedSTR = new String(decodedByteArray);
        System.out.println("decodedSTR = " + decodedSTR);
    }
}
