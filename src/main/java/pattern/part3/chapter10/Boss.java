package pattern.part3.chapter10;

/**
 * Date: 2010-2-19
 * Time: 0:10:11
 */
public class Boss {
    private Assistant assistant;

    public Boss(Assistant assistant) {
        this.assistant = assistant;
    }

    public void treat() {
        assistant.prepareDinner();
        address();
        assistant.endDinner();
    }

    private void address() {
        System.out.println("Boss is bitching : \"Tomorrow is going to be better, we will make blah blah...\"");
    }
}
