import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class KeyRing {
	static List<Key> keyRing = new ArrayList<Key>();

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		int menuFlag = 0;
		int option = 0;
		do {
			//output menu 
			System.out.println("1.) Create Key\n2.) Delete Key\n3.) Use Key"); 
			option = userInput.nextInt();
			//need to add exception if input isn't 0<option<4
			
			//option 1 adds a key
			if (option==1) {
				Key key = new Key();
				
				System.out.println("Enter user ID: ");
				key.setPassphrase(userInput.nextLine());
				
				
				System.out.println("Enter the number of bits: ");
				key.setBits(userInput.nextInt());
				
				
				//do while confirms passphrase, then adds the key to the keyring
				boolean passFlag = false;
				do {
					System.out.println("Enter a passphrase: ");
					String passphrase = userInput.nextLine();
					System.out.println("Confirm passphrase: ");
					String confirmPassphrase = userInput.nextLine();
					
					
					if (passphrase != confirmPassphrase) {
						System.out.println("Passes don't match");
					}
					else {
						key.setPassphrase(confirmPassphrase);
						keyRing.add(key);
						passFlag = true;
					}
				}while(passFlag);
			}
			
			else if (option==2) {
				System.out.println("Enter UserID of key you would like to remove: ");
				String removeUserID = userInput.nextLine();
				
				//haven't input validated for null
				Key keyToRemove = findKey(removeUserID);
				keyRing.remove(keyToRemove);
			}
			
			//this one needs work. Only listing the UserIDs of all the keys so far
			else if (option==3) {
				System.out.println("Which key would you like to use? ");
				for (Key iterateKey : keyRing) {
					System.out.println(iterateKey.getUserID());
				}
			}
			
		}while(menuFlag == 1);
	
	}
	
	//refactor please
	static Key findKey(String userID) {
		for (Key key : keyRing) {
			if (key.getUserID() == userID) {
				return key;
			}
		}
		return null;
	}

}
