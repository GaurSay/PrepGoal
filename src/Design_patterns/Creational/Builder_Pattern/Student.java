package Design_patterns.Creational.Builder_Pattern;

public class Student {
    public String getName() {
        return name;
    }

    public int getId() {
        return Id;
    }

    public String getUniversity() {
        return university;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    private String name;
    private int Id;
    private String university;
    private int age;
    private String email;
    private Student(Builder b){
        this.age = b.getAge();
        this.name = b.getName();
        this.email = b.getEmail();
        this.Id = b.getId();
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private String name;
        private int Id;
        private String university;
        private int age;
        private String email;

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public int getId() {
            return Id;
        }

        public Builder setId(int id) {
            Id = id;
            return this;
        }

        public String getUniversity() {
            return university;
        }

        public Builder setUniversity(String university) {
            this.university = university;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Student build(){
            return new Student(this);
        }

    }

}
