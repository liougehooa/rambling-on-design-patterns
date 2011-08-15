package pattern.part4.chapter13.tiger;

/**
 * Date: 2010-7-25
 * Time: 17:33:17
 */
public enum Color implements State {
    RED {
        @Override
        public void push(PaintBoard paintBoard) {
            paintBoard.setState(GREEN);
        }

        @Override
        public void pull(PaintBoard paintBoard) {
            paintBoard.setState(BLUE);
        }
    },
    GREEN {
        @Override
        public void push(PaintBoard paintBoard) {
            paintBoard.setState(BLUE);
        }

        @Override
        public void pull(PaintBoard paintBoard) {
            paintBoard.setState(RED);
        }
    },
    BLUE {
        @Override
        public void push(PaintBoard paintBoard) {
            paintBoard.setState(RED);
        }

        @Override
        public void pull(PaintBoard paintBoard) {
            paintBoard.setState(GREEN);
        }
    };

    @Override
    public void push(PaintBoard paintBoard) {
        throw new UnsupportedOperationException("Invalid push!");
    }

    @Override
    public void pull(PaintBoard paintBoard) {
        throw new UnsupportedOperationException("Invalid pull!");
    }
}
