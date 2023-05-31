package com.example.lab9;


    public class MoveResult {
        private boolean moveSuccess;
        private boolean gameSuccess;

        public MoveResult(boolean moveSuccess, boolean gameSuccess) {
            this.moveSuccess = moveSuccess;
            this.gameSuccess = gameSuccess;
        }

        public boolean isMoveSuccess() {
            return moveSuccess;
        }

        public boolean isGameSuccess() {
            return gameSuccess;
        }

        @Override
        public String toString() {
            return "MoveResult [moveSuccess=" + moveSuccess + ", gameSuccess=" + gameSuccess + "]";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            MoveResult other = (MoveResult) obj;
            if (moveSuccess != other.moveSuccess)
                return false;
            if (gameSuccess != other.gameSuccess)
                return false;
            return true;
        }

    }

