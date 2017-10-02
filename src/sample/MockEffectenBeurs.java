package sample;
import java.util.ArrayList;
import java.util.List;

public class MockEffectenBeurs implements IEffectenBeurs {

    private List<IFonds> koersen;

    public MockEffectenBeurs() {
        koersen = new ArrayList<IFonds>();
        koersen.add(new Fonds("Mo bv",10));
        koersen.add(new Fonds("Nick bv",10));
    }

    @Override
    public List<IFonds> getKoersen() {
        return koersen;
    }

    public String toString(){
        String result = "";
        for (IFonds fonds: koersen
             ) {
            result += fonds.toString()+ " ";
        }
        return result;
    }
}