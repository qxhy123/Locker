package cn.xpbootcamp.locker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.instanceOf;

//Given Locker有空柜  When 存包 Then 存包成功，给小票
//Given Locker柜已满  When 存包 Then 存包失败，提示用户柜已满
//Given 有效小票      When 取包 Then 取包成功
//Given 已使用过的小票 When 取包 Then 取包失败，提示票据无效
//Given 假的小票      When 取包 Then 取包失败，提示票据无效
public class LockerTest {

    @Test
    public void should_store_success_and_provide_ticket_when_store_bag_given_locker_has_capacity() {
        int capacity = 10;
        int occupied = 5;
        Locker locker = new Locker(capacity, occupied);
        locker.store();
        Assert.assertEquals(Locker.SUCCESS, locker.getStatus());
        Assert.assertThat(locker.getTicket(), instanceOf(LockerTicket.class));
    }

    @Test
    public void should_store_fail_and_show_user_locker_is_full_when_store_bag_given_locker_has_no_capacity() {
        int capacity = 10;
        int occupied = 10;
        Locker locker = new Locker(capacity, occupied);
        locker.store();
        Assert.assertEquals(Locker.FAIL, locker.getStatus());
        Assert.assertEquals(Locker.LOCKER_IS_FULL, locker.getMessage());
    }

    @Test
    public void should_pick_success_when_pick_bag_given_valid_ticket() {
        int capacity = 10;
        int occupied = 5;
        Locker locker = new Locker(capacity, occupied);
        LockerTicket lockerTicket = new LockerTicket();
        locker.pickWithTicket(lockerTicket);
        Assert.assertEquals(Locker.SUCCESS, locker.getStatus());
    }

    @Test
    public void should_pick_fail_and_show_user_ticket_invalid_when_pick_bag_given_used_ticket() {
        int capacity = 10;
        int occupied = 5;
        Locker locker = new Locker(capacity, occupied);
        LockerTicket lockerTicket = new LockerTicket();
        lockerTicket.setUsed(true);
        locker.pickWithTicket(lockerTicket);
        Assert.assertEquals(Locker.FAIL, locker.getStatus());
        Assert.assertEquals(Locker.TICKET_IS_INVALID, locker.getMessage());
    }

    @Test
    public void should_pick_fail_and_show_user_ticket_invalid_when_pick_bag_given_fake_ticket() {
        int capacity = 10;
        int occupied = 5;
        Locker locker = new Locker(capacity, occupied);
        LockerTicket lockerTicket = new LockerTicket();
        lockerTicket.setFake(true);
        locker.pickWithTicket(lockerTicket);
        Assert.assertEquals(Locker.FAIL, locker.getStatus());
        Assert.assertEquals(Locker.TICKET_IS_INVALID, locker.getMessage());
    }
}
