package mics;

public class Foo {
    private enum Level {
        HIGH (3),
        MEDIUM(2),
        LOW (1)
        ;

        private final int levelCode;

        private Level (int levelCode){
            this.levelCode = levelCode;
        }

        public int getLevelCode() {
            return levelCode;
        }
    }

    public static void main(String[] args) {
        Level level = Level.MEDIUM;

        System.out.println(level.getLevelCode());
        System.out.println(Level.LOW);
    }
}


