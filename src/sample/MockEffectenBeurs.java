package sample;
import java.util.List;

public class MockEffectenBeurs implements IEffectenBeurs {

    private List<IFonds> koersen;

    @Override
    public List<IFonds> getKoersen() {
        return koersen;
    }
}
