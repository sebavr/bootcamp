package com.codingdojo.web.models;

import java.util.ArrayList;

public class Roster {
	private ArrayList<Team> teams = new ArrayList<Team>();

	public ArrayList<Team> getTeams() {
		return teams;
	}
	
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
	public void addteam (Team team_name) {
		getTeams().add(team_name);
	}
	
	public Team getTeam(int index) {
		return teams.get(index);
	}
	
	public void deleteTeam(Team t) {
		int index = teams.indexOf(t);
		teams.remove(index);
	}
}