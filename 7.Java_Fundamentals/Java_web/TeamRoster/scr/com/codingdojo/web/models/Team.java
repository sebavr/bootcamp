package com.codingdojo.web.models;

import java.util.ArrayList;

public class Team {
	private String team_name;
	ArrayList<Player> players = new ArrayList<Player>();

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	
	public Team(String team_name) {
		this.team_name = team_name;
	}
	
	public Player getPlayer(int index) {
		return players.get(index);
	}
	
	public void addplayer (Player p) {
		players.add(p);
	}
	
	public void deletePlayer(Player p) {
		int index = players.indexOf(p);
		players.remove(index);
	}
}