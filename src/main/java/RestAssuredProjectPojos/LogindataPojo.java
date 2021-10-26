package RestAssuredProjectPojos;

public class LogindataPojo {
	

    private String image;

    private String date_added;

    private String firstname;

    private String user_group;

    private String user_id;

    private String ip;

    private String user_group_id;

    private String email;

    private String username;

    private String lastname;

    private String status;

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getDate_added ()
    {
        return date_added;
    }

    public void setDate_added (String date_added)
    {
        this.date_added = date_added;
    }

    public String getFirstname ()
    {
        return firstname;
    }

    public void setFirstname (String firstname)
    {
        this.firstname = firstname;
    }

    public String getUser_group ()
    {
        return user_group;
    }

    public void setUser_group (String user_group)
    {
        this.user_group = user_group;
    }

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }

    public String getIp ()
    {
        return ip;
    }

    public void setIp (String ip)
    {
        this.ip = ip;
    }

    public String getUser_group_id ()
    {
        return user_group_id;
    }

    public void setUser_group_id (String user_group_id)
    {
        this.user_group_id = user_group_id;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    public String getLastname ()
    {
        return lastname;
    }

    public void setLastname (String lastname)
    {
        this.lastname = lastname;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [image = "+image+", date_added = "+date_added+", firstname = "+firstname+", user_group = "+user_group+", user_id = "+user_id+", ip = "+ip+", user_group_id = "+user_group_id+", email = "+email+", username = "+username+", lastname = "+lastname+", status = "+status+"]";
    }

}
