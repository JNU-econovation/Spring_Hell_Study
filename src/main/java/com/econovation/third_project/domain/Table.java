package com.econovation.third_project.domain;

import lombok.Getter;

@Getter
public enum Table {
    zerozero(0,0),zeroone(0,1),zerotwo(0,2),zerothree(0,3),zerofour(0,4),zerofive(0,5),zerosix(0,6),zeroseven(0,7),zeroeight(0,8),zeronine(0,9),zeroten(0,10),
    onezero(1,0),oneone(1,1),onetwo(1,2),onethree(1,3),onefour(1,4),onefive(1,5),onesix(1,6),oneseven(1,7),oneeight(1,8),onenine(1,9),oneten(1,10),
    twozero(2,0),twoone(2,1),twotwo(2,2),twothree(2,3),twofour(2,4),twofive(2,5),twosix(2,6),twoseven(2,7),twoeight(2,8),twonine(2,9),twoten(10,10),
    ;

    private Integer row;
    private Integer column;


    Table(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }

    public int[] toArray(){
        return new int[]{this.getRow(), this.getColumn()};
    }
}
