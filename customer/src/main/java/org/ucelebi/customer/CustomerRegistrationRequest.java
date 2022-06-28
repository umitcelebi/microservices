package org.ucelebi.customer;

/**
 * @author UMITCELEBI
 */
public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
