public class Task02DataRepresentation {
    public static void main(String[] args) {
        // Jagged array: each floor can have a different number of slots.
        String[][] slots = new String[3][];
        slots[0] = new String[20];
        slots[1] = new String[50];
        slots[2] = new String[30];

        int floor = 1;
        int slot = 4;
        double ratePerHour = 30.0;
        int minutes = 125;

        // Ceiling division: every started hour is billed.
        int billableHours = (minutes + 59) / 60;
        double fee = billableHours * ratePerHour;

        slots[floor][slot] = "TN02CD4567";
        System.out.println("Vehicle at floor " + floor + ", slot " + slot
                + ": " + slots[floor][slot]);
        System.out.println("Billable hours: " + billableHours);
        System.out.println("Fee: Rs " + fee);
        System.out.println("Floors: " + slots.length);
    }
}
