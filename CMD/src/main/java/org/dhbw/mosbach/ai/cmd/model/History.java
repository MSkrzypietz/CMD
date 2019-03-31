package org.dhbw.mosbach.ai.cmd.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Model class for the 'history' table.
 * @author 3040018
 */
@Entity
@Table(name="history")
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column(name="CONTENT")
	private String content;
	
	@Column(name="HASH")
	private String hash;
	
	@Column(name="CTIME")
	private LocalDateTime ctime;
	
	@Column(name="UTIME")
	private LocalDateTime utime;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_DOCS")
	private Doc doc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public LocalDateTime getCtime() {
		return ctime;
	}

	public void setCtime(LocalDateTime ctime) {
		this.ctime = ctime;
	}

	public LocalDateTime getUtime() {
		return utime;
	}

	public void setUtime(LocalDateTime utime) {
		this.utime = utime;
	}

	public Doc getDoc() {
		return doc;
	}

	public void setDoc(Doc doc) {
		this.doc = doc;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("User: \n")
				.append("\tid: "   + this.id + "\n")
				.append("\tHash: " + this.hash + "\n")
				.append("\tCreated: " + this.ctime + "\n")
				.append("\tLast updated: " + this.utime + "\n")
				.append("\tDocument: " + this.doc.getId() + "\n")
				.append("\tContent: " + this.content + "\n")
				.toString();
	}
}