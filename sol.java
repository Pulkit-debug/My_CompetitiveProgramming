import java.util.*;
import java.lang.*;
import java.io.*;

public class sol {

    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 

    
    public static boolean[] SES(int n) {
        // SES Stands for SieveOfEratoSthenes
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2;i*i<=n;i++) {
            for(int j = 2*i;j<=n;j+=i) {
                isPrime[j] = false; 
            }

        }
        return isPrime;
    }

    public static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a%b);
    }

    public static long fastPower(long a, long b, long n) {
        long res = 1;
        while(b > 0) {
            if( (b&1) != 0) {
                res = (res % n * a % n) % n;
            }

            a = (a % n * a % n) % n;
            b = b >> 1; // dividing by 2
        }
        return res;
    }


    public static void main(String[] args) throws IOException {

        // ************** Providing input File
        // File file = new File("input.txt");
        // BufferedReader br = new BufferedReader(new FileReader(file));



        // *************** Input for Online Judges with Buffered Reader
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));




        // ************* Input for Online Judges with Scanner class
        // Reading with Scanner class
        // Scanner sc = new Scanner(file);
        // sc.useDelimiter("\\Z");


        // ***************** Printing Outout to output file.
        // PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        // printWriter.println("something here");
        // printWriter.close();    --->>  // only this close method will flush the output from the buffer to the output file.

      
        }

    }
