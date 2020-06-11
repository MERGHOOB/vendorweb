package com.margub.vendor.repos;

import com.margub.vendor.entities.Vendor;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface for generic CRUD operations on a repository for vendor
 */
public interface IVendorRepository extends CrudRepository<Vendor, Integer> {
}
