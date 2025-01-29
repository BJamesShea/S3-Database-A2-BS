import java.util.Scanner;

public class FilmTheatre {
    private static final int ROWS = 5;
    private static final int COLUMNS = 5;
    private static char[][] seats = new char[ROWS][COLUMNS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initSeats();

        while (true) {
            System.out.println("\nFilm Theatre Seat Reservation System");
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
                    System.out.println("Invalid choice. Try again.");
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
        System.out.println("\nSeating Chart:");
        System.out.print("  ");
        for (int i = 0; i < COLUMNS; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < ROWS; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void reserveSeat(Scanner scanner) {
        System.out.print("Enter row number (1-" + ROWS + "): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter column number (1-" + COLUMNS + "): ");
        int col = scanner.nextInt() - 1;

        if (isValidSeat(row, col)) {
            if (seats[row][col] == 'O') {
                seats[row][col] = 'X';
                System.out.println("Seat reserved successfully!");
            } else {
                System.out.println("Seat is already taken! Suggesting an available seat...");
                suggestAvailableSeat();
            }
        } else {
            System.out.println("Invalid seat selection. Please enter a valid row and column.");
        }
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.print("Enter row number (1-" + ROWS + ") to cancel: ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter column number (1-" + COLUMNS + ") to cancel: ");
        int col = scanner.nextInt() - 1;

        if (isValidSeat(row, col)) {
            if (seats[row][col] == 'X') {
                seats[row][col] = 'O';
                System.out.println("Reservation canceled!");
            } else {
                System.out.println("Seat was not reserved.");
            }
        } else {
            System.out.println("Invalid seat selection.");
        }
    }

    private static boolean isValidSeat(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLUMNS;
    }

    private static void suggestAvailableSeat() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (seats[i][j] == 'O') {
                    System.out.println("Available seat suggestion: Row " + (i + 1) + ", Column " + (j + 1));
                    return;
                }
            }
        }
        System.out.println("This showing is now sold out, please choose another time.");
    }
}
