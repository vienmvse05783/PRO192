
package persons;

import java.util.*;

public class person {

    String name;
    String d;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public person(String name, String d, int age) {
        this.name = name;
        this.d = d;
        this.age = age;
    }

    @Override
    public String toString() {
        return "\n" + name + "\t" + d + "\t" + getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class studen extends person implements Comparable {

    float grad;

    public studen(float grad, String name, String d, int age) {
        super(name, d, age);
        this.grad = grad;
    }

    public float getGrad() {
        return grad;
    }

    public void setGrad(float grad) {
        this.grad = grad;
    }

    @Override
    public String toString() {
        return "\n" + name + "\t" + d + "\t" + getAge() + "\t" + grad;
    }

    @Override
    public int compareTo(Object t) {
        studen temp = (studen) t;
        return name.compareTo(temp.name);
    }

}

class Managers {

    int n;
    ArrayList<studen> arra = new ArrayList();

    void inputMany(int n) {
        Scanner sc = new Scanner(System.in);
        String xname;
        String xd;
        int xage;
        float grad;
        for (int i = 0; i < n; i++) {
            System.out.print("Name=");
            xname = String.valueOf(sc.next());
            System.out.print("D=");
            xd = sc.next();
            System.out.print("age=");
            xage = sc.nextInt();
            System.out.print("grad=");
            grad = sc.nextFloat();
            arra.add(new studen(grad, xname, xd, xage));
        }
    }

    void outputMany(int n) {

        for (int i = 0; i < n; i++) {
            System.out.println(arra.get(i));
        }
    }

    void sort(int n) {

        Collections.sort(arra);
    }

    public static Comparator ano = new Comparator() {
        @Override
        public int compare(Object t, Object t1) {
            studen em1, em2;
            em1 = (studen) t;
            em2 = (studen) t1;
            float d = em1.grad - em2.grad;
            if (d > 0) {
                return 1;
            } else if (d == 0) {
                return 0;
            } else {
                return -1;
            }
        }
    };
    
    public static Comparator ano1=new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            studen em1, em2;
            em1 = (studen) o1;
            em2 = (studen) o2;
            return em1.getAge()-em2.getAge();
        }
    };
    
    void sortByAge(){        
        Collections.sort(arra, ano1);
    };

    int find(int n) {
        return (Collections.binarySearch(arra, new studen(6, "1", "1", 2), ano));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Managers ob = new Managers();
        System.out.print("n=");
        ob.n = sc.nextInt();

        ob.inputMany(ob.n);
        ob.outputMany(ob.n);
        ob.sort(ob.n);
        ob.outputMany(ob.n);
        ob.sortByAge();
        System.out.println("After sort:");
        ob.outputMany(ob.n);        
        System.out.println(" find");
        System.out.println(ob.arra.get(ob.find(ob.n)));

    }

}
