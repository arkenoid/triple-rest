package com.middleware;

public class Registration {

    private final long id;
    private final String content;

    public Registration(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

	@Override
	public String toString() {
		return "Registration [id=" + id + ", content=" + content + "]";
	}
    
}
