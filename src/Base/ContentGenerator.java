package Base;

import java.util.ArrayList;

public  abstract class ContentGenerator<T> {

    public ArrayList<T> content = new ArrayList<T>();

    protected void initContent() {
        for(int i=0; i < randomRange(3, 10); i++){
            content.add(Unit(i+1));
        }
    }

    abstract protected T Unit(int id);

    protected int randomRange(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
