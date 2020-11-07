package MainGame.Planets;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class Locker {
    public static final Lock LOCKER_EARTH = new ReentrantLock();
    public static final Lock LOCKER_ORBIT = new ReentrantLock();
    public static final Lock LOCKER_MARS = new ReentrantLock();
}
