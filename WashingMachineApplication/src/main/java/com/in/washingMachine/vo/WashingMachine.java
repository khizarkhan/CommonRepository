package com.in.washingMachine.vo;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.in.washingMachine.vo.programe.WashingMachineFunction;

import javax.persistence.*;
import java.util.List;

/**
 * Created by khizar khan
 */
@Entity
@Table(name = "TB_APPLIANCES")
public class WashingMachine extends JPA implements Appliance, Programmable  {
    private String model;
    private String serial;
    private List<WashingMachineFunction> programs;

    @Override
    @Basic(optional = false)
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    @Basic(optional = false)
    @Column(name = "serial")
    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(fetch = FetchType.EAGER)
    public List<WashingMachineFunction> getPrograms() {
        return programs;
    }

    public void setPrograms(List<WashingMachineFunction> programs) {
        this.programs = programs;
    }
}
