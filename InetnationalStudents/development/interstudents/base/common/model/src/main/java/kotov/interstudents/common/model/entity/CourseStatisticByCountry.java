package kotov.interstudents.common.model.entity;

/**
 * Created by vkotov on 01.04.2015.
 */
public class CourseStatisticByCountry {
    private Country country;
    private int count0 = 0;
    private int count1 = 0;
    private int count2 = 0;
    private int count3 = 0;
    private int count4 = 0;
    private int count5 = 0;
    private int countII = 0;
    private int countIII = 0;
    private int countA = 0;
    private int countK = 0;
    private int countAll = 0;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getCount0() {
        return count0;
    }

    public void setCount0(int count0) {
        this.count0 = count0;
    }

    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public int getCount2() {
        return count2;
    }

    public void setCount2(int count2) {
        this.count2 = count2;
    }

    public int getCount3() {
        return count3;
    }

    public void setCount3(int count3) {
        this.count3 = count3;
    }

    public int getCount4() {
        return count4;
    }

    public void setCount4(int count4) {
        this.count4 = count4;
    }

    public int getCount5() {
        return count5;
    }

    public void setCount5(int count5) {
        this.count5 = count5;
    }

    public int getCountII() {
        return countII;
    }

    public void setCountII(int countII) {
        this.countII = countII;
    }

    public int getCountIII() {
        return countIII;
    }

    public void setCountIII(int countIII) {
        this.countIII = countIII;
    }

    public int getCountA() {
        return countA;
    }

    public void setCountA(int countA) {
        this.countA = countA;
    }

    public int getCountK() {
        return countK;
    }

    public void setCountK(int countK) {
        this.countK = countK;
    }

    public int getCountAll() {
        return this.countAll;
    }

    public void setCountAll(int countAll) {
        this.countAll = countAll;
    }

    public void addCount0(){
        this.count0++;
        this.countAll++;
    }

    public void addCount1(){
        this.count1++;
        this.countAll++;
    }

    public void addCount2(){
        this.count2++;
        this.countAll++;
    }

    public void addCount3(){
        this.count3++;
        this.countAll++;
    }

    public void addCount4(){
        this.count4++;
        this.countAll++;
    }

    public void addCount5(){
        this.count5++;
        this.countAll++;
    }

    public void addCountII(){
        this.countII++;
        this.countAll++;
    }

    public void addCountIII(){
        this.countIII++;
        this.countAll++;
    }

    public void addCountK(){
        this.countK++;
        this.countAll++;
    }

    public void addCountA(){
        this.countA++;
        this.countAll++;
    }
}
