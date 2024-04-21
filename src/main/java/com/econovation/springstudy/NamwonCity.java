package com.econovation.springstudy;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class NamwonCity {
    private AtomicLong atomicBalance = new AtomicLong(1_000_000);

    public long checkBalance(){
        return this.atomicBalance.get();
    }

    private void addBalanceToAtomicBalance(int moneyToAdd){
        long balance;
        do {
            balance = this.atomicBalance.get();
            if (balance + moneyToAdd < 0) throw new IllegalArgumentException("돈이 부족해요");
        }while(!this.atomicBalance.compareAndSet(balance, balance + moneyToAdd));
    }

    public void addBalance(int balanceToAdd){
        if (balanceToAdd <= 0) throw new IllegalArgumentException("1원 이상 입력");
        addBalanceToAtomicBalance(balanceToAdd);
    }

    public void deductBalance(int balanceToDeduct){
        if (balanceToDeduct <= 0) throw new IllegalArgumentException("1원 이상 입력");
        addBalanceToAtomicBalance(-balanceToDeduct);
    }

}
