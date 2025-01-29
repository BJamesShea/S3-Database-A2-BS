import java.util.Scanner;

public class FilmTheatre {
    private static int ROWS = 5;
    private static int COLUMNS = 5;
    private static char[][] seats = new char[ROWS][COLUMNS];


    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        initSeats();

        while (true) {
            System.out.println("Film Theatre seat reservation system!");
            System.out.println("1. Show seats");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showSeats();
                    break;

                case 2:
                    reserveSeat(scanner);
                    break;

                case 3:
                    cancelReservation(scanner);
                    break;

                case 4:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid. Try again.");
            }
        }
    }

    private static void initSeats() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                seats[i][j] = 'O';
            }
        }
    }


    private static void showSeats() {
        System.out.println("  1 2 3 4 5");
        for (int i = 0; i < ROWS; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }



















}
