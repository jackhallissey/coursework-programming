import java.util.ArrayList;

class Lab6 {
    public static void main(String[] args) {
        ArrayList<String> modules = new ArrayList<>();
        modules.add("Cryptography");
        modules.add("Databases");
        modules.add("OS");
        modules.add("Networking");
        System.out.println(modules);
        // modules.remove("Networking");
        // modules.remove(3);
        for (int i = 0; i < modules.size(); i++) {
            if ("Networking".equals(modules.get(i))) {
                modules.remove(i);
                break;
            }
        }
        System.out.println(modules);
    }
}