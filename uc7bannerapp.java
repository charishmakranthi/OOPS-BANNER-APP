public class UC7Banner {

    // Inner static class to hold character patterns
    static class CharacterPattern {
        private final char character;
        private final String[] pattern;

        public CharacterPattern(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public char getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    // Static inner class to manage mappings
    static class CharacterPatternMap {
        private static final java.util.Map<Character, CharacterPattern> patternMap = new java.util.HashMap<>();

        static {
            // Define ASCII art patterns for characters
            patternMap.put('O', new CharacterPattern('O', new String[]{
                " *** ",
                "*   *",
                "*   *",
                "*   *",
                " *** "
            }));

            patternMap.put('P', new CharacterPattern('P', new String[]{
                "**** ",
                "*   *",
                "**** ",
                "*    ",
                "*    "
            }));

            patternMap.put('S', new CharacterPattern('S', new String[]{
                " ****",
                "*    ",
                " *** ",
                "    *",
                "**** "
            }));
        }

        public static CharacterPattern getPattern(char c) {
            return patternMap.get(Character.toUpperCase(c));
        }
    }

    // Method to display banner for a word
    public static void displayBanner(String word) {
        StringBuilder[] bannerLines = new StringBuilder[5];
        for (int i = 0; i < 5; i++) {
            bannerLines[i] = new StringBuilder();
        }

        for (char c : word.toCharArray()) {
            CharacterPattern cp = CharacterPatternMap.getPattern(c);
            if (cp != null) {
                String[] pattern = cp.getPattern();
                for (int i = 0; i < 5; i++) {
                    bannerLines[i].append(pattern[i]).append("  ");
                }
            }
        }

        // Print the banner
        for (StringBuilder line : bannerLines) {
            System.out.println(line);
        }
    }

    // Main method
    public static void main(String[] args) {
        displayBanner("OOPS");
    }
}
