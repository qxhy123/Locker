package cn.xpbootcamp.locker;

public class LockerTicket {
    private boolean used;
    private boolean fake;

    public boolean isValid() {
        return !used && !fake;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public void setFake(boolean fake) {
        this.fake = fake;
    }
}
