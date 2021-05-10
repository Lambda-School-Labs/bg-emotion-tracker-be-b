package com.lambdaschool.oktafoundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * The entity allowing interaction with the activities table
 */
@ApiModel(value = "Activities", description = "Activities available")
@Entity
@Table(name = "activities")
public class Activity extends Auditable
{
    @ApiModelProperty(name = "Activity Id",
            value = "Primary Key for Activity",
            required = true,
            example = "1"
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long activityid;
    
    /**
     * Part of the join relationship between Club and Activities
     * connects clubs to the club activities combination
     */
    @ApiModelProperty(name = "Activity Name",
            value = "Full activity name",
            required = true,
            example = "Piano Lessons"
            )
    @Column(nullable = false)
    private String activityname;


    @ApiModelProperty(name = "Club Activity Join",
            value = "Join Table",
            required = true
    )
    @OneToMany(mappedBy = "activity",
            cascade = CascadeType.ALL,
            orphanRemoval = true)

    @JsonIgnoreProperties(value = {"activity","reactions"}, allowSetters = true)
    private Set<ClubActivities> clubs = new HashSet<>();


    /**
     * Default constructor used primarily by the JPA.
     */
    public Activity() {
    }
    /**
     * Given the params, create a new activity object
     * <p>
     * userid is autogenerated
     *
     * @param activityname The activityname (String) of the user
     */
    public Activity(String activityname) {
        this.activityname = activityname;
    }

    /**
     * Getter for activityid
     *
     * @return the userid (long) of the user
     */
    public long getActivityid() {
        return activityid;
    }
    /**
     * Setter for activityid. Used primary for seeding data
     *
     * @param activityid the new userid (long) of the user
     */
    public void setActivityid(long activityid) {
        this.activityid = activityid;
    }
    /**
     * Getter for club activities combinations
     *
     * @return A list of club activity combinations associated with this activity
     */
    public Set<ClubActivities> getClub() {
        return clubs;
    }
    /**
     * Setter for user role combinations
     *
     * @return A list of club activity combinations associated with this activity
     */
    public void setClub(Set<ClubActivities> club) {
        this.clubs = club;
    }
    /**
     * Getter for club activity combinations
     *
     * @return A list of club activity combinations associated with this activity
     */
    public Set<ClubActivities> getClubs() {
        return clubs;
    }
    /**
     * Getter for activityname
     */
    public String getActivityname() {
        return activityname;
    }
    /**
     * setter for activityname
     *
     * @param activityname the new activityname (String)
     */
    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }
}
