package minghua.common.imporvejava.serialization;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 场景
 * 一个人力资源管理系统需要和计税系统通过rmi进行远程对接
 * 人力资源系统中，员工工资分为基本工资+绩效工资，其中绩效工资对计税系统保密
 */
@Getter
@Setter
public class Salary implements Serializable {
    private static final long serialVersionUID = 1L;
    //基本工资
    private int basePay;
    //绩效工资
    private int bonus;

    public Salary(int basePay, int bonus) {
        this.basePay = basePay;
        this.bonus = bonus;
    }
}
