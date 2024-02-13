/**
 * @param {number[]} nums1 - первый отсортированный массив
 * @param {number} m - количество значимых элементов в nums1
 * @param {number[]} nums2 - второй отсортированный массив
 * @param {number} n - количество элементов в nums2
 * @return {void} Не возвращайте ничего, вместо этого модифицируйте nums1.
 */
module.exports = function merge(nums1, m, nums2, n) {
    var index1 = m - 1;
    var index2 = n - 1;
    var indexTotal = n + m - 1;
    while (index1 >= 0 && index2 >= 0) {
        if (nums1[index1] > nums2[index2]) {
            nums1[indexTotal] = nums1[index1];
            index1--;
        } else {
            nums1[indexTotal] = nums2[index2];
            index2--;
        }
        indexTotal--;
    }
    while (index2 >= 0) {
        nums1[indexTotal] = nums2[index2];
        index2--;
        indexTotal--;
    }
 }
