package com.in.washingMachine.vo.programe;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.in.washingMachine.process.Drying;
import com.in.washingMachine.process.Squeaking;
import com.in.washingMachine.process.Washing;
import com.in.washingMachine.vo.JPA;

/**
 * Created by khizar khan
 */
@Entity
@Table(name = "TB_PROGRAMS")
public class WashingMachineFunction extends JPA {
    private Washing washing;
    private Squeaking squeaking;
    private Drying drying;

    public WashingMachineFunction() {
    }

    public WashingMachineFunction(Washing washing, Squeaking squeaking, Drying drying) {
        this.washing = washing;
        this.squeaking = squeaking;
        this.drying = drying;
    }

    @OneToOne(optional = false)
    @JoinColumn(name = "washing")
    public Washing getWashing() {
        return washing;
    }

    public void setWashing(Washing washing) {
        this.washing = washing;
    }

    @OneToOne(optional = false)
    @JoinColumn(name = "squeaking")
    public Squeaking getSqueaking() {
        return squeaking;
    }

    public void setSqueaking(Squeaking squeaking) {
        this.squeaking = squeaking;
    }

    @OneToOne(optional = false)
    @JoinColumn(name = "drying")
    public Drying getDrying() {
        return drying;
    }

    public void setDrying(Drying drying) {
        this.drying = drying;
    }

    @Override
    public String toString() {
        return "Program{" +
                "\n\t\t" + washing.toString() +
                ", \n\t\t" + squeaking.toString() +
                ", \n\t\t" + drying.toString() +
                "\n}\n";
    }
}
