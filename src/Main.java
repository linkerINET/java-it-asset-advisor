public class Main {
    record Requirement(String role, boolean development, boolean videoEditing, boolean travelOften, int budget) {}
    record Recommendation(String cpu, int ramGb, int storageGb, String notes) {}

    public static void main(String[] args) {
        Requirement request = new Requirement("Software Developer", true, false, true, 1400);
        Recommendation result = recommend(request);

        System.out.println("=== IT Asset Recommendation Advisor ===");
        System.out.println("Role: " + request.role());
        System.out.println("Recommended CPU: " + result.cpu());
        System.out.println("Recommended RAM: " + result.ramGb() + " GB");
        System.out.println("Recommended storage: " + result.storageGb() + " GB SSD");
        System.out.println("Consultant note: " + result.notes());
    }

    static Recommendation recommend(Requirement r) {
        int ram = r.videoEditing() ? 32 : r.development() ? 16 : 8;
        int storage = (r.development() || r.videoEditing()) ? 512 : 256;
        String cpu = r.development() || r.videoEditing() ? "Modern 8-core CPU" : "Modern 4-6 core CPU";
        String notes = r.travelOften() ? "Choose a business laptop under 1.6 kg with USB-C charging." :
                "A standard business laptop or desktop is suitable.";
        if (r.budget() < 800) notes += " Consider a refurbished business-class model.";
        return new Recommendation(cpu, ram, storage, notes);
    }
}
