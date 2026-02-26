package tdd.lock;

public class SimpleSmartDoorLock implements SmartDoorLock {
    private static final int EMPTY_PIN = -1;
    private static final int MAX_PIN = 9999;
    private static final int MAX_ATTEMPTS = 3;
    private int pin = EMPTY_PIN;
    private int failedAttempts = 0;
    private boolean locked = false;
    private boolean blocked = false;

    @Override
    public void setPin(int pin) {
        if (!locked && pin <= MAX_PIN) {
            this.pin = pin;
        }
    }

    private void blockDoor() {
        blocked = true;
    }

    private void handleFailedAttempt() {
        this.failedAttempts = this.failedAttempts + 1;
        if (this.failedAttempts >= MAX_ATTEMPTS) {
            blockDoor();
        }
    }

    @Override
    public void unlock(int pin) {
        if (this.pin == EMPTY_PIN) {
            throw new IllegalStateException();
        }
        if (!blocked && locked) {
            if (this.pin == pin) {
                this.locked = false;
            } else {
                handleFailedAttempt();
            }
        }
    }

    @Override
    public void lock() {
        if (this.pin == EMPTY_PIN) {
            throw new IllegalStateException();
        }
        this.locked = true;
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isBlocked() {
        return blocked;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {
        locked = false;
        blocked = false;
        pin = EMPTY_PIN;
    }
}
