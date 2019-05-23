class linkedlist
{
    linkedlist next;
    String data;
    int age;
    String city;
 
    public linkedlist(String name, int age, String city)
    {
        data = name;
        this.age = age;
        this.city = city;
        next = null;
    }
}