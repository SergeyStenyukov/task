package ofd.platforma.task.domain;

import ofd.platforma.task.domain.enums.BalanceType;

import java.time.LocalDateTime;

public class Balance {

    private int id;

    private Long amount;

    private BalanceType type;

    private LocalDateTime localDateTime;

    private int user_id;

    public Balance() {
    }

    public Balance(int id, Long amount,
                   BalanceType type, LocalDateTime localDateTime, int user_id) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.localDateTime = localDateTime;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public BalanceType getType() {
        return type;
    }

    public void setType(BalanceType type) {
        this.type = type;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "id=" + id +
                ", amount=" + amount +
                ", type=" + type +
                ", localDateTime=" + localDateTime +
                ", user_id=" + user_id +
                '}';
    }
}
