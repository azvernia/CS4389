
public class Key {

		private String userID;
		private String passphrase;  //the passphrase used for your private key
		private int bits;			//the number of bits for your RSA key
		
		public Key() {
			this.userID = "";
			this.passphrase = "";
			this.bits = 0;
		}
		
		public Key(String userID, String passphrase, int bits) {
			this.userID = userID;
			this.passphrase = passphrase;
			this.bits = bits;
		}

		public int getBits() {
			return bits;
		}

		public void setBits(int bits) {
			this.bits = bits;
		}

		public String getUserID() {
			return userID;
		}

		public void setUserID(String userID) {
			this.userID = userID;
		}

		public String getPassphrase() {
			return passphrase;
		}

		public void setPassphrase(String passphrase) {
			this.passphrase = passphrase;
		}
		
}




