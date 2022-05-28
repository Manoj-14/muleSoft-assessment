package muleSoft;

import java.util.*;

public class mainCls {
	public static void main(String[] args) {

		String db, tblName;
		char ch;

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		for (;;) {
			System.out.println("a:Create DB \nb:Create Table\nc:Insert\nd:Select\ne:Exit\nEnter Your Choice:");
			ch = scanner.next().charAt(0);
			ch = Character.toLowerCase(ch);
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			switch (ch) {

			case 'a':
				System.out.println("Enter the database name");
				db = input.nextLine();
				Connect.connect(db);
				System.out.println("A new database has been created.");
				break;
			case 'b':
				System.out.println("Enter the database name");
				db = input.nextLine();
				if(Connect.check(db)) {
					Connect.connect(db);
					System.out.println("Enter the table name");
					tblName = input.nextLine();
					CreateTable.createNewTable(db, tblName);
					System.out.println("New Table " + tblName + " created");
					
				}
				else {
					System.out.println("No such database");
				}
				
				break;
			case 'c':
				System.out.println("Enter the database name");
				db = input.nextLine();
				if (Connect.check(db)) {
					Connect.connect(db);
					System.out.println("New database " + db + " created");
					CreateTable.listTables(db);
					System.out.println("Enter the table name");
					tblName = input.nextLine();
					CreateTable.createNewTable(db, tblName);
					System.out.println("Table " + tblName + " created");
					InsertData insdata = new InsertData();
					insdata.insert(db, tblName);
				} else {
					System.out.println("No such database");
				}
				break;
			case 'd':
				System.out.println("1:Select All\n2:Select by Actor name");
				int choice = input.nextInt();
				Scanner inp = new Scanner(System.in);
				switch (choice) {
				case 1:
					System.out.println("Enter the database name");
					db = inp.nextLine();
					if (Connect.check(db)) {
						Connect.connect(db);
						CreateTable.listTables(db);
						System.out.println("Enter the table name");
						tblName = inp.nextLine();
						CreateTable.createNewTable(db, tblName);
						System.out.println("Table " + tblName + " created");
						Select selectAl = new Select();
						selectAl.selectAll(db, tblName);
					} else {
						System.out.println("No such database");
					}
					break;
				case 2:

					System.out.println("Enter the database name");
					db = inp.nextLine();
					if (Connect.check(db)) {
						Connect.connect(db);

						CreateTable.listTables(db);
						System.out.println("Enter the table name");
						tblName = inp.nextLine();
						System.out.println("Enter the Actor name");
						String actorName = inp.nextLine();
						CreateTable.createNewTable(db, tblName);

						Select selectByMov = new Select();
						selectByMov.selectByActor(db, tblName, actorName);
					} else {
						System.out.println("No such database");
					}

					break;
				default:
					System.out.println("Invalid Option");
				}
				break;
			case 'e' :
				System.out.println("Thank You");
				return ;
			default:
				System.out.println("Invalid Option Please Try Again.....!");
			}
		}
	}
}
