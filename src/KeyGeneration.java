import java.math.BigInteger;
import java.util.Random;
public class KeyGeneration {
	private BigInteger PublicKey, PrivateKey;
	private BigInteger e;
	
	public KeyGeneration(){
			//Choose random prime numbers of bit length 128
			Random rnd = new Random();
			BigInteger p = BigInteger.probablePrime(128, rnd);
			BigInteger q = BigInteger.probablePrime(128, rnd);
			
			//Calculate n for public key
			BigInteger n = p.multiply(q);
			
			//Calculate p-1 and q-1
			BigInteger p1 = p.subtract(BigInteger.ONE);
			BigInteger q1 = q.subtract(BigInteger.ONE);
			
			//Compute totient
			BigInteger totient = p1.multiply(q1);
			
			//Random e greater than 1 and less than totient
			this.e = nextRandomBigInteger(totient);
			
			//Make sure e relatively prime to totient
			while(gcd(e,totient) == false){
				e = nextRandomBigInteger(totient);
			}
			
			//Compute private key 
			BigInteger d = e.modInverse(totient);
			this.PublicKey = n;
			this.PrivateKey= d;
	}
	
	//returns public key n
	public BigInteger getPublicKey(){
		return this.PublicKey;
	}
	
	//returns value of e
	public BigInteger getE(){
		return this.e;
	}
	
	//returns private key
	private BigInteger getPrivateKey(){
		return this.PrivateKey;
	}
	
	//This function returns a random BigInteger greater than 1 and less than input n
	public BigInteger nextRandomBigInteger(BigInteger n) {
	    Random rand = new Random();
	    BigInteger result = new BigInteger(n.bitLength(), rand);
	    while( result.compareTo(n) >= 0 && result.compareTo(BigInteger.ONE)<= 0 ) {
	        result = new BigInteger(n.bitLength(), rand);
	    }
	    return result;
	}
	
	//determine if relatively prime inputs
	public boolean gcd(BigInteger p, BigInteger q){
		BigInteger t;
		while(q != BigInteger.ZERO)
		{
			t = p;
			p = q;
			q = t.mod(q);
		}
		if(p.compareTo(BigInteger.ONE)== 0)
		{
			return true;
		}
		return false;
	}
	
	//test function to encrypt/decrypt message
	/*
	public static void main(String[] args) {
		KeyGeneration keys = new KeyGeneration();
		StringBuilder sb = new StringBuilder();
		String message = "Test message";
		char[] letters = message.toCharArray();
		for(char ch: letters){
			sb.append((byte)ch);
		}
		message = sb.toString();
		BigInteger m = new BigInteger(message);
		System.out.println(m);
		//BigInteger m = BigInteger.valueOf(Integer.parseInt(message));
		BigInteger c = m.modPow(keys.getE(), keys.getPublicKey());
		System.out.println(c);
		BigInteger d = c.modPow(keys.getPrivateKey(), keys.getPublicKey());
		System.out.println(d);	
	}
	*/
	
}
