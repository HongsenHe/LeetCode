/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, 
it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) 
that reads n characters from the file.

Note:
The read function will only be called once for each test case.
*/

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */

/*
copy from CleanCodeHandBook_v1.0.3
Solution:
This seemingly easy coding question has some tricky edge cases. When read4 returns
less than 4, we know it must reached the end of file. However, take note that read4
returning 4 could mean the last 4 bytes of the file.
To make sure that the buffer is not copied more than n bytes, copy the remaining bytes
(n – readBytes) or the number of bytes read, whichever is smaller.
*/
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
    	char[] buffer = new char[4];
    	int readBytes = 0;
    	boolean eof = false;
    	
    	while (!eof && readBytes < n) {
    		int sz = read4(buffer);
    		if (sz < 4) eof = true;
    		
    		int bytes = Math.min(n - readBytes, sz);
    		System.arraycopy(buffer /* src */, 0 /* srcPos */,
    			buf /* dest */, readBytes /* destPos */, bytes /* length */);
    		readBytes += bytes;
    	}
    	
    	return readBytes;
    }
}