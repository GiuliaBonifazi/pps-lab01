package tdd;

import java.util.Optional;

public class SimpleSmartDoorLock implements SmartDoorLock {
    private static final int EMPTY_PIN = -1;
    private int pin = EMPTY_PIN;
    private int failedAttempts = 0;
    private boolean locked = false;

    @Override
    public void setPin(int pin) {
        if (!locked) {
            this.pin = pin;
        }
    }

    @Override
    public void unlock(int pin) {
        if (this.pin == EMPTY_PIN) {
            throw new IllegalStateException();
        } else if (this.pin == pin) {
            this.locked = false;
        } else {
            this.failedAttempts = this.failedAttempts + 1;
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
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {

    }
}
