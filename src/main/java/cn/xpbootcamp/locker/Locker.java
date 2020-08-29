package cn.xpbootcamp.locker;

public class Locker {
    public static final String FAIL = "FAIL";
    public static final String SUCCESS = "SUCCESS";
    public static final String LOCKER_IS_FULL = "Locker is full";
    public static final String TICKET_IS_INVALID = "Ticket is invalid";
    private final int capacity;
    private final int occupied;
    private String status;
    private String message;

    public Locker(int capacity, int occupied) {
        this.capacity = capacity;
        this.occupied = occupied;
    }

    public void store() {
        if (occupied < capacity) {
            setStatus(SUCCESS);
        } else {
            setStatus(FAIL);
            setMessage(LOCKER_IS_FULL);
        }
    }

    private void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public LockerTicket getTicket() {
        return new LockerTicket();
    }

    public String getMessage() {
        return message;
    }

    public void pickWithTicket(LockerTicket lockerTicket) {
        validTicket(lockerTicket);
    }

    private void validTicket(LockerTicket lockerTicket) {
        if (lockerTicket.isValid()) {
            setStatus(SUCCESS);
        } else {
            setStatus(FAIL);
            setMessage(TICKET_IS_INVALID);
        }
    }

    private void setMessage(String message) {
        this.message = message;
    }
}
