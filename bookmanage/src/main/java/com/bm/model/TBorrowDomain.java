package com.bm.model;

public class TBorrowDomain {

        private Integer id;

        private TUser user;

        private TBook book;

        private String borrowDate;

        private String alsoDate;

        private Integer isAlso;

        private Integer isContinue;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public TUser getUser() {
            return user;
        }

        public void setUser(TUser user) {
            this.user = user;
        }

        public TBook getBook() {
                return book;
            }

        public void setBook(TBook book) {
            this.book = book;
        }

        public String getBorrowDate() {
            return borrowDate;
        }

        public void setBorrowDate(String borrowDate) {
            this.borrowDate = borrowDate == null ? null : borrowDate.trim();
        }

        public String getAlsoDate() {
            return alsoDate;
        }

        public void setAlsoDate(String alsoDate) {
            this.alsoDate = alsoDate == null ? null : alsoDate.trim();
        }

        public Integer getIsAlso() {
            return isAlso;
        }

        public void setIsAlso(Integer isAlso) {
            this.isAlso = isAlso;
        }

        public Integer getIsContinue() {
            return isContinue;
        }

        public void setIsContinue(Integer isContinue) {
            this.isContinue = isContinue;
        }

    @Override
    public String toString() {
        return "TBorrowDomain{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                ", borrowDate='" + borrowDate + '\'' +
                ", alsoDate='" + alsoDate + '\'' +
                ", isAlso=" + isAlso +
                ", isContinue=" + isContinue +
                '}';
    }
}
